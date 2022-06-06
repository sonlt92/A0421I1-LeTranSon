import {Component, OnInit} from '@angular/core';
import {Division} from "../../interface/division";
import {Position} from "../../interface/position";
import {EducationDegree} from "../../interface/educationDegree";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Subscription} from "rxjs";
import {Employee} from "../../interface/employee";
import {EmployeeService} from "../../services/EmployeeService";
import {Router} from "@angular/router";
import {DivisionService} from "../../services/DivisionService";
import {PositionService} from "../../services/PositionService";
import {EducationDegreeService} from "../../services/EducationDegreeService";
import {validAgeValidators} from "../../shared/valid-age.validators";
import {validSelectValidators} from "../../shared/valid-select.validators";

@Component({
  selector: 'app-add-new-employee',
  templateUrl: './add-new-employee.component.html',
  styleUrls: ['./add-new-employee.component.css']
})
export class AddNewEmployeeComponent implements OnInit {

  divisions: Division[] = [];
  positions: Position[] = [];
  educationDegrees: EducationDegree[] = [];
  employeeForm!: FormGroup;

  private subscription!: Subscription;

  constructor(private _employeeService: EmployeeService,
              private _router: Router,
              private _divisionService: DivisionService,
              private _positionService: PositionService,
              private _educationDegreeService: EducationDegreeService) {

    this.employeeForm = new FormGroup(
      {
        id: new FormControl(),
        position: new FormControl(0, [validSelectValidators()]),
        division: new FormControl(0, [validSelectValidators()]),
        educationDegree: new FormControl(0, [validSelectValidators()]),
        fullName: new FormControl('', [Validators.required, Validators.pattern("^([A-Z][a-z]+)( [A-Z][a-z]+)+$")]),
        birthday: new FormControl('', [Validators.required, validAgeValidators(18,70)]),
        idCard: new FormControl('', [Validators.required, Validators.pattern("^(([0-9]{12})|([0-9]{9})){1}$")]),
        phone: new FormControl('', [Validators.required, Validators.pattern("^(090)|(091)[0-9]{7}$")]),
        email: new FormControl('', [Validators.required, Validators.email]),
        salary: new FormControl('', [Validators.required, Validators.pattern("^[0-9]+$")])
      }
    )
  }

  ngOnInit(): void {
    this.getAllDivision();
    this.getAllEducationDegree();
    this.getAllPosition();
  }

  onsubmit() {
    this.employeeForm.value.id = "NV-" + Math.floor(Math.random() * 1000);
    this.addNewEmployee(this.employeeForm.value);
  }

  addNewEmployee(employee: Employee) {
    this.subscription = this._employeeService.addNewEmployee(employee).subscribe(() => {
      this._router.navigateByUrl('/employee/show?msg=success').then(() => {
      });
    })
  }

  getAllDivision() {
    this._divisionService.getAllDivision().subscribe((data) => {
      this.divisions = data;
    })
  }

  getAllPosition() {
    this._positionService.getAllPosition().subscribe((data) => {
      this.positions = data;
    })
  }

  getAllEducationDegree() {
    this._educationDegreeService.getAllEducationDegree().subscribe((data) => {
      this.educationDegrees = data;
    })
  }


}
