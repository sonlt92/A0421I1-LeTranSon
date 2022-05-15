import { Component, OnInit } from '@angular/core';
import {IStudent} from "../../models/iStudent";

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {
  student:IStudent={
    id: 1,
    name: "Son",
    age: 30,
    mark: 10,
    avatar: "https://cdn.bhdw.net/im/league-of-legends-lol-adventurer-teemo-legends-of-runeterra-hinh-nen-64210_w635.jpg"
}
  constructor() { }

  ngOnInit(): void {
  }

}
