import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../../services/CustomerService";
import {ActivatedRoute, Router} from "@angular/router";
import {GenderService} from "../../services/GenderService";
import {TypeCusService} from "../../services/TypeCusService";
import {Gender} from "../../interface/gender";
import {TypeCus} from "../../interface/typeCus";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Customer} from "../../interface/customer";
import {validSelectValidators} from "../../shared/valid-select.validators";
import {validAgeValidators} from "../../shared/valid-age.validators";

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  genders: Gender[] = [];
  typeCus: TypeCus[] = [];
  customer!: Customer;
  customerForm!: FormGroup;
  id: string = '';

  constructor(private _customerService: CustomerService,
              private _router: Router,
              private _activeRouter: ActivatedRoute,
              private _genderService: GenderService,
              private _typeCusService: TypeCusService) {
    this._activeRouter.paramMap.subscribe((param) => {
      this.id = <string>param.get('id');
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
      });
      this._customerService.getCustomerByID(this.id).subscribe((data) => {
        this.customer = data;
        this.customerForm.patchValue(this.customer);
      })
    })
  }

  ngOnInit(): void {
    this.getAllGender();
    this.getAllTypeCus();
  }

  onsubmit() {
    this._genderService.getGenderById(this.customerForm.value.gender).subscribe((data) => {
      this.customerForm.value.gender = data;
      console.log(data);
      this._typeCusService.getTypeCusById(this.customerForm.value.idTypeCus).subscribe((data) => {
        this.customerForm.value.idTypeCus = data;
        console.log(data);
        this.customer = this.customerForm.value;
        console.log(this.customer);
        this._customerService.updateCustomer(this.customer).subscribe(() => {
          this._router.navigateByUrl('/customer/show?msg=success').then(() => {
          });
        });
      })
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
