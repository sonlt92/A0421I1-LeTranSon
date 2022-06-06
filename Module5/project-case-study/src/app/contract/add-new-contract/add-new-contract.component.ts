import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {Employee} from "../../interface/employee";
import {Customer} from "../../interface/customer";
import {Service} from "../../interface/service";
import {ContractService} from "../../services/ContractService";
import {EmployeeService} from "../../services/EmployeeService";
import {CustomerService} from "../../services/CustomerService";
import {ServiceService} from "../../services/ServiceService";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-new-contract',
  templateUrl: './add-new-contract.component.html',
  styleUrls: ['./add-new-contract.component.css']
})
export class AddNewContractComponent implements OnInit {
  contractForm!: FormGroup;
  employees!: Employee[];
  customers!: Customer[];
  services!: Service[];
  service: Service | null = null;
  deposit: number = 0;
  total: number = 0;

  constructor(private _router: Router,
              private _contractService: ContractService,
              private _employeeService: EmployeeService,
              private _customerService: CustomerService,
              private _serviceService: ServiceService) {
    this.getAllCustomer();
    this.getAllEmployee();
    this.getAllService();
    this.contractForm = new FormGroup({
      id: new FormControl(),
      employee: new FormControl(),
      customer: new FormControl(),
      service: new FormControl(),
      startDate: new FormControl(),
      endDate: new FormControl(),
      deposit: new FormControl(),
      total: new FormControl()
    })
  }

  ngOnInit(): void {

  }

  onsubmit() {
    this.contractForm.value.id = "HD-" + Math.floor(Math.random() * 1000);
    this._contractService.addNewContract(this.contractForm.value).subscribe(()=>{
      this._router.navigateByUrl('/contract/show?msg=success').then(() => {
      });
    })
  }

  getAllCustomer() {
    this._customerService.getAllCustomer().subscribe((data) => {
      this.customers = data;
    })
  }

  getAllEmployee() {
    this._employeeService.getAllEmployee().subscribe((data) => {
      this.employees = data;
    })
  }

  getAllService() {
    this._serviceService.getAllService().subscribe((data) => {
      this.services = data;
    })
  }

  onchange() {
    // @ts-ignore
    this.total = this.service?.cost - this.deposit;
  }
}
