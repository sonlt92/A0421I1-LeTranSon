import {Position} from "./position";
import {Division} from "./division";
import {EducationDegree} from "./educationDegree";

export interface Employee {
  id: string;
  position: Position;
  division: Division;
  educationDegree: EducationDegree;
  fullName: string;
  birthday: string;
  idCard: string;
  phone: string;
  email: string;
  salary: number;
}
