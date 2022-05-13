import {Injectable} from '@angular/core';
import {IStudent} from "../../models/iStudent";
import {StudentDao} from "../../dao/StudentDao";

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {
  constructor() {
  }

  addNewStudent(student: IStudent) {
    StudentDao.studentDao.push(student);
  }

  findStudentById(id: string): IStudent {
    // @ts-ignore
    return StudentDao.studentDao.find((student) => student.id == id);
  }
}
