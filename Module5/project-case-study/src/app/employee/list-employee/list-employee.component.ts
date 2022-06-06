import {Component, OnInit} from '@angular/core';
import {Employee} from "../../interface/employee";
import {EmployeeService} from "../../services/EmployeeService";
import {ActivatedRoute} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";
import {Division} from "../../interface/division";
import {Position} from "../../interface/position";
import {EducationDegree} from "../../interface/educationDegree";
import {DivisionService} from "../../services/DivisionService";
import {PositionService} from "../../services/PositionService";
import {EducationDegreeService} from "../../services/EducationDegreeService";


@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {
  public employees: Employee[] = [];
  divisions: Division[] = [];
  positions: Position[] = [];
  educationDegrees: EducationDegree[] = [];
  public msg: string = "";
  size: number = 0;
  maxPage: number = 0;
  private readonly LiMIT: number = 10;
  pageNow: number = 1;
  checkSearch: number = 0;
  searchEmployeeForm: FormGroup;

  constructor(private _employeeService: EmployeeService,
              private _activeRouter: ActivatedRoute,
              private _divisionService: DivisionService,
              private _positionService: PositionService,
              private _educationDegreeService: EducationDegreeService) {
    this.getPageEmployee(1, this.LiMIT);
    this.getAllEmployee();

    this.searchEmployeeForm = new FormGroup({
      name: new FormControl(''),
      education: new FormControl(0),
      position: new FormControl(0),
      division: new FormControl(0),
    })
  }

  ngOnInit(): void {
    this.getAllDivision();
    this.getAllEducationDegree();
    this.getAllPosition();
    this._activeRouter.queryParamMap.subscribe((param) => {
      if (param.get('msg') == "success") {
        this.msg = "successfully added new!"
      }
    })
  }

  getAllEmployee() {
    this._employeeService.getAllEmployee().subscribe(data => {
      this.size = data.length;

      if (this.size % this.LiMIT != 0) {
        this.maxPage = Math.floor(this.size / this.LiMIT) + 1;
      } else {
        this.maxPage = this.size / this.LiMIT;
      }
    });
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

  getPageEmployee(page: number, limit: number) {
    this._employeeService.getPageEmployee(page, limit).subscribe((data) => {
      this.employees = data;
    })
  }

  delete(id: string, nameEmployee: string) {
    this._employeeService.deleteEmployee(id).subscribe(() => {
      // @ts-ignore
      document.getElementById('row' + id).remove();
      this.msg = "successfully deleted employee " + nameEmployee + "!";
    })
  }

  prevPage(page: number) {
    if (this.checkSearch == 0) {
      if (page == 0) {
        page = 1;
        this.getPageEmployee(page, this.LiMIT);
      } else {
        this.getPageEmployee(page, this.LiMIT);
        this.pageNow--;
      }
    } else {
      if (page == 0) {
        page = 1;
        this.getPageSearchEmployee(page, this.LiMIT);
      } else {
        this.getPageSearchEmployee(page, this.LiMIT);
        this.pageNow--;
      }
    }

  }


  nextPage(page: number) {
    if (this.checkSearch == 0) {
      if (page > this.maxPage) {
        page = this.maxPage;
        this.getPageEmployee(page, this.LiMIT);
      } else {
        this.getPageEmployee(page, this.LiMIT);
        this.pageNow++;
      }
    }else {
      if (page > this.maxPage) {
        page = this.maxPage;
        this.getPageSearchEmployee(page, this.LiMIT);
      } else {
        this.getPageSearchEmployee(page, this.LiMIT);
        this.pageNow++;
      }
    }
  }

  getPageSearchEmployee(page: number, limit: number) {
    const formValue = this.searchEmployeeForm.value;
    this._employeeService.searchEmployee(formValue.name, formValue.division, formValue.education, formValue.position, page, limit).subscribe((data) => {
      this.employees = data;
    })
  }

  onSubmit() {
    const formValue = this.searchEmployeeForm.value;
    this._employeeService.searchEmployee(formValue.name, formValue.division, formValue.education, formValue.position, 1, this.LiMIT).subscribe((data) => {
      this.employees = data;
      this.checkSearch = 1;
      this.size = data.length;

      if (this.size % this.LiMIT != 0) {
        this.maxPage = Math.floor(this.size / this.LiMIT) + 1;
      } else {
        this.maxPage = this.size / this.LiMIT;
      }
    })
  }
}
