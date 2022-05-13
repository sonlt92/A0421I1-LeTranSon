import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {StudentServiceService} from "../service/student-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {
  formCreateStudent: FormGroup;

  constructor(private studentService: StudentServiceService,
              private router:Router) { }

  ngOnInit(): void {
    this.formCreateStudent = new FormGroup({
      id: new FormControl('',[Validators.required, Validators.max(100)]),
      name: new FormControl('',[Validators.required]),
      age: new FormControl(),
      mark: new FormControl(),
      avatar: new FormControl()
    });
  }

  createStudent(){
    this.studentService.addNewStudent(this.formCreateStudent.value);
    this.router.navigateByUrl("");
  }

}
