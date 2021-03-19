// Model Plants

type Plant = {
  sowWeeks: number[]; // 52 weken
  harvestWeeks: number[]; 
  detestedNeighbor: Plant;
  preferredNeighbor: Plant;
}
