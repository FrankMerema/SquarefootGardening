To start the application run ` ./mvnw spring-boot:run`

Then you can query this:

```bash
curl -i -X POST http://localhost:8080/timeTable/solve -H "Content-Type:application/json" -d '{"timeslotList":[{"dayOfWeek":"MONDAY","startTime":"08:30:00","endTime":"09:30:00"},{"dayOfWeek":"MONDAY","startTime":"09:30:00","endTime":"10:30:00"}],"roomList":[{"name":"Room A"},{"name":"Room B"}],"lessonList":[{"id":1,"subject":"Math","teacher":"A. Turing","studentGroup":"9th grade"},{"id":2,"subject":"Chemistry","teacher":"M. Curie","studentGroup":"9th grade"},{"id":3,"subject":"French","teacher":"M. Curie","studentGroup":"10th grade"},{"id":4,"subject":"History","teacher":"I. Jones","studentGroup":"10th grade"}]}'
```

# Makkelijke Moestuin Planner

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
curl -X POST http://localhost:8080/timeTable/solve -H "Content-Type:application/json" -d '@./request.json' > response.json
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

- Companion planting  
  https://www.permaculturenews.org/wp-content/uploads/2010/07/Companion-planting-chart-pdf-download-permaculture.pdf
