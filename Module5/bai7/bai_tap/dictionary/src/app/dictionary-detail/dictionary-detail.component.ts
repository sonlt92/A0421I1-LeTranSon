import { Component, OnInit } from '@angular/core';
import {DictionaryServiceService} from "../dictionary-service.service";
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {

  key: string = '';
  result: string = '';

  constructor(private dictionaryService: DictionaryServiceService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      if (id != null) {
        this.key = id;
        // @ts-ignore
        this.result = this.dictionaryService.search(this.key);
      }
    });
  }
}

