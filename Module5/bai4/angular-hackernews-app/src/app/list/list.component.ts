import { Component, OnInit } from '@angular/core';
import {articles} from "../linkList";
import {link} from "../interface";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  articles : link[] =articles
  constructor() { }

  ngOnInit(): void {
  }

}
