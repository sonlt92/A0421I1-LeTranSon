import {Employee} from "./employee";
import {Customer} from "./customer";
import {Service} from "./service";

export interface Contract {
  id: number;
  employee: Employee;
  customer: Customer;
  service: Service;
  startDate: string;
  endDate: string;
  deposit: number;
  total: number;
}
