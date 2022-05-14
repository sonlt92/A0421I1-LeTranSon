import { Component, OnInit } from '@angular/core';
import {DictionaryServiceService} from "../dictionary-service.service";

@Component({
  selector: 'app-dictionary',
  templateUrl: './dictionary.component.html',
  styleUrls: ['./dictionary.component.css']
})
export class DictionaryComponent implements OnInit {
  word!: IWord;
  constructor(private dictionaryService: DictionaryServiceService) { }

  ngOnInit(): void {
  }

  search(word: string){
    const meaning = this.dictionaryService.search(word);
    this.word = {
      word: word,
      mean: meaning
    };
  }

}
