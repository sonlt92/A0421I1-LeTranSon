import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DictionaryServiceService {

  words: IWord[] = [
    {word: 'hello', mean: 'xin chao'},
    {word: 'like', mean: 'thich'},
    {word: 'commnent', mean: 'binh luan'},
    {word: 'subscribe', mean: 'dang ky'},
    {word: 'keyboard', mean: 'ban phim'},
  ];
  constructor() { }

  search(word: string): string{
    if(!word){
      return '';
    }
    const w = this.words.find(item => item.word === word.toLowerCase());
    if(w){
      return w.mean;
    }
    return 'Không tìm thấy kết quả!!!';
  }
}
