import { Component, OnInit } from '@angular/core';
import {DictionaryServiceService} from "../dictionary-service.service";


@Component({
  selector: 'app-dictionay-page',
  templateUrl: './dictionay-page.component.html',
  styleUrls: ['./dictionay-page.component.css']
})
export class DictionayPageComponent implements OnInit {

  // @ts-ignore
  words!: IWord[];
  constructor(private dictionaryService: DictionaryServiceService) {
    this.words = this.dictionaryService.words;
  }

   ngOnInit(): void {
  }

}
