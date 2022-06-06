import {Component, OnInit} from '@angular/core';
import {Division} from "../../interface/division";
import {Position} from "../../interface/position";
import {EducationDegree} from "../../interface/educationDegree";
import {EmployeeService} from "../../services/EmployeeService";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Employee} from "../../interface/employee";
import {ActivatedRoute, Router} from "@angular/router";
import {DivisionService} from "../../services/DivisionService";
import {PositionService} from "../../services/PositionService";
import {EducationDegreeService} from "../../services/EducationDegreeService";
import {validSelectValidators} from "../../shared/valid-select.validators";
import {validAgeValidators} from "../../shared/valid-age.validators";

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {
  divisions: Division[]=[];
  positions: Position[]=[];
  educationDegrees: EducationDegree[]=[];
  employee!: Employee;
  id: string = '';
  employeeForm!: FormGroup;


  constructor(private _employeeService: EmployeeService,
              private _router: Router,
              private _activeRouter: ActivatedRoute,
              private _divisionService: DivisionService,
              private _positionService: PositionService,
              private _educationDegreeService: EducationDegreeService) {

    this._activeRouter.paramMap.subscribe((param) => {
      this.id = <string>param.get('id');
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
      this._employeeService.getEmployeeById(this.id).subscribe((data) => {
        this.employee = data;
        this.employeeForm.patchValue(this.employee)
      })
    });
  }

  ngOnInit(): void {
    this.getAllDivision();
    this.getAllEducationDegree();
    this.getAllPosition();
  }

  onsubmit() {
    this._educationDegreeService.getEducationDegreeById(this.employeeForm.value.educationDegree).subscribe((data) => {
      this.employeeForm.value.educationDegree = data;
      console.log(data);
      this._positionService.getPositionById(this.employeeForm.value.position).subscribe((data) => {
        this.employeeForm.value.position = data;
        this._divisionService.getDivisionById(this.employeeForm.value.division).subscribe((data) => {
          this.employeeForm.value.division = data;
          this.employee = this.employeeForm.value;
          this._employeeService.updateEmployee(this.employee).subscribe(() => {
            this._router.navigateByUrl('/employee/show?msg=success').then(() => {
            });
          });
        })
      })
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
