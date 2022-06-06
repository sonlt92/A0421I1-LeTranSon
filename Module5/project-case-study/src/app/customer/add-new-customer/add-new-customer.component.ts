import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {TypeCus} from "../../interface/typeCus";
import {Gender} from "../../interface/gender";
import {CustomerService} from "../../services/CustomerService";
import {Customer} from "../../interface/customer";
import {Router} from "@angular/router";
import {GenderService} from "../../services/GenderService";
import {TypeCusService} from "../../services/TypeCusService";
import {validSelectValidators} from "../../shared/valid-select.validators";
import {validAgeValidators} from "../../shared/valid-age.validators";

@Component({
  selector: 'app-add-new-customer',
  templateUrl: './add-new-customer.component.html',
  styleUrls: ['./add-new-customer.component.css']
})
export class AddNewCustomerComponent implements OnInit {

  genders: Gender[] = [];
  typeCus: TypeCus[] = [];
  customerForm!: FormGroup;


  constructor(private _customerService: CustomerService,
              private _router: Router,
              private _genderService: GenderService,
              private _typeCusService: TypeCusService) {

    this.getAllGender();
    this.getAllTypeCus();
    this.customerForm = new FormGroup({
      id: new FormControl(),
      idTypeCus: new FormControl(0,[validSelectValidators()]),
      fullName: new FormControl('',[Validators.required, Validators.pattern("^([A-Z][a-z]+)( [A-Z][a-z]+)+$")]),
      gender: new FormControl(0,[validSelectValidators()]),
      dateOfBirth: new FormControl('',[Validators.required,validAgeValidators(18,70)]),
      idCard: new FormControl('', [Validators.required, Validators.pattern("^(([0-9]{12})|([0-9]{9})){1}$")]),
      phone: new FormControl('', [Validators.required, Validators.pattern("^(090)|(091)[0-9]{7}$")]),
      email: new FormControl('', [Validators.required, Validators.email]),
      address: new FormControl('',[Validators.required])
    })
  }

  ngOnInit(): void {
  }

  onsubmit() {
    this.customerForm.value.id = "KH-" + Math.floor(Math.random() * 1000);
    this.addNewCustomer(this.customerForm.value);
  }

  addNewCustomer(customer: Customer) {
    this._customerService.addNewCustomer(customer).subscribe(() => {
      this._router.navigateByUrl('/customer/show?msg=success').then(() => {
      });
    })
  }

  getAllGender() {
    this._genderService.getAllGender().subscribe((data) => {
      this.genders = data;
    })
  }

  getAllTypeCus() {
    this._typeCusService.getAllTypeCus().subscribe((data) => {
      this.typeCus = data;
    })
  }
}
