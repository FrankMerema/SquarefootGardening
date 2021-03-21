To start the application run ` ./mvnw spring-boot:run`

Then you can query this:

```bash
curl -i -X POST http://localhost:8080/planner/solve -H "Content-Type:application/json" -d '{"timeslotList":[{"dayOfWeek":"MONDAY","startTime":"08:30:00","endTime":"09:30:00"},{"dayOfWeek":"MONDAY","startTime":"09:30:00","endTime":"10:30:00"}],"roomList":[{"name":"Room A"},{"name":"Room B"}],"lessonList":[{"id":1,"subject":"Math","teacher":"A. Turing","studentGroup":"9th grade"},{"id":2,"subject":"Chemistry","teacher":"M. Curie","studentGroup":"9th grade"},{"id":3,"subject":"French","teacher":"M. Curie","studentGroup":"10th grade"},{"id":4,"subject":"History","teacher":"I. Jones","studentGroup":"10th grade"}]}'
```

# Makkelijke Moestuin Planner

## User requirements

Request Requirement:

- select **plants**
- preferred **amount** of plants
- preferred **harvest** time: early, middle, late

Result Requirements:

- optimized **companion** planting
- optimized **time** of planting/harvest
- optimized **succession** planting


## Getting started

```bash
./mvnw clean install
# ./mvnw clean install -DskipTests
```

Start application

```bash
./mvnw spring-boot:run
```

Send request to server

```bash
curl -X POST http://localhost:8080/planner/solve -H "Content-Type:application/json" -d '@./request.json' > response.json
```

## Model

Tuin

- plant

  - vak (x,y)
  - timeslot

- plant
  - weekOptions array<timeslot>
  - preferredNeighbor array<plant>
  - detestedNeighbor array<plant>
  - detestedAfter array<plant>

Tuin

- 4 bakken (1,2m \* 1,2m)
  - 16 vakken (30cm \* 30cm)

## Constraints

Plaatsing (companion planting)

- HARD -1: plant1.position NOT plant2.position
- HARD -1: aangrenzend(plant1.position, plant2.position) NOT IN
  combine(plant1.detestedNeighbor, plant2.detestedNeighbor)
- SOFT 0: NOT hierboven, en hieronder
- SOFT 1: aangrenzend(plant1.position, plant2.position) IS IN
  combine(plant1.preferredNeighbor, plant2.preferredNeighbor)

Seizoen (succesion planting)

- HARD -1: overlap in moment van in de grond zijn
- HARD -1: plaatsing.timeslot NOT IN plant.weekOptions
- HARD -1: plant1.weekOptions NOT OVERLAP plant2.weekOptions && plant1.position
  NOT plant2.position

# LINKS

- Spreadsheet met uitkomst  
  https://docs.google.com/spreadsheets/d/1Xm-5y0-jwUvVu-lHs1Mhs2-yAwOpSIywVzD5wG0FkRU/edit?usp=sharing

- OptaPlanner constraints  
  https://docs.optaplanner.org/8.4.0.Final/optaplanner-docs/html_single/index.html#_define_the_constraints_and_calculate_the_score

- Sowing (glass, garden), Harvest and Companion Planting  
  https://when2plant.com/wp-content/uploads/2014/11/Sowing_calendar_1xA2_when_to_plant_vegetables_herbs_companion_planting.pdf

- Zaaien (binnen, buiten), Oogsten en Combinatieteelt  
  https://zaaikalender.com/

- Companion planting  
  https://www.permaculturenews.org/wp-content/uploads/2010/07/Companion-planting-chart-pdf-download-permaculture.pdf

- Wiki list of companion plants  
  https://en.wikipedia.org/wiki/List_of_companion_plants

- Plant Harmony database
  https://github.com/micahlmartin/Plant-Harmony/tree/master/data

## Data collection 

### Scraping data

- when2plant.uk
- zaaikalender.com

```js
let data = []
Array.from(document.getElementsByTagName('table')[0].getElementsByTagName('tr')).slice(2).map(tr => Array.from(tr.getElementsByTagName('td')).map(td => {
  if(td.innerText.replace(/\s/g, '').length > 0) {
    return td.innerText
  } else if(td.getAttribute('bgcolor')) {
    switch(td.getAttribute('bgcolor')) {
      case "#FFFF00": 
        return "-glass";
      case "#00FF00": 
        return "-plant";
      case "#FF6600": 
        return "-harvest";
    }
  } else {
    return null;
  }
})).filter(tr => !tr.find(td => ("" + td).includes('Jan')))
.map((row, i, arr) => {
  if (i / 3 % 1 === 0) {
    const first = row;
    const second = arr[i+1];
    const third = arr[i+2];
    return {first, second, third};
  } else {
    return null;
  }
})
.filter(x => x)
.forEach(({ first, second, third }) => {
    const [name, ...rest] = first;
    let [inchDistance, daysUntilHarvest, daysUntilGermination, ...glass] = rest.reverse();
    glass = glass.map((value, i) => !value || i+1).filter(x => x !== true);
    const seeding = second.map((value, i) => !value || i+1).filter(x => x !== true);
    const harvest = third.map((value, i) => !value || i+1).filter(x => x !== true);
    data.push({ name, glass, seeding, harvest, inchDistance, daysUntilHarvest, daysUntilGermination});
});
data
```