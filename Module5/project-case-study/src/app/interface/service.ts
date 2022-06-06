import {RentType} from "./rentType";

export interface Service {
  id: string;
  fullName: string;
  area: number;
  cost: number;
  maxPeople: number;
  idRentType: RentType;
  numberOfFloors: number;
  status: string
}
