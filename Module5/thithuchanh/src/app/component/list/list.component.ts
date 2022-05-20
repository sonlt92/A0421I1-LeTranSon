import {Component, OnInit} from '@angular/core';
import {ComponentService} from '../services/component.service';
import {BenhAnModel} from '../models/benhAnModel';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  listBenhAn: BenhAnModel[];

  constructor(private service: ComponentService) {
  }

  ngOnInit(): void {
    this.service.getList().subscribe(next => this.listBenhAn = next);
  }
}
