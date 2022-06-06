import {TypeCus} from "./typeCus";
import {Gender} from "./gender";

export interface Customer {
  id: string;
  idTypeCus: TypeCus;
  fullName: string;
  gender: Gender;
  dateOfBirth: string;
  idCard: string;
  phone: string;
  email: string;
  address: string;
}
