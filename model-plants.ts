// Model Plants

type json = {
  plants: Plant[];
};

type Plant = {
  sowWeeks: number[]; // 52 weken
  harvestWeeks: number[];
  detestedNeighbor: Plant[];
  preferredNeighbor: Plant[];
};
