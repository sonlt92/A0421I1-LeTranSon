import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  number1: number;
  number2: number;
  result: any;


  constructor() { }

  ngOnInit(): void {
  }

  addition() {
    this.result = this.number1 + this.number2;
  }

  subtraction() {
    this.result = this.number1 - this.number2;
  }

  multiplication() {
    this.result = this.number1 * this.number2;
  }

  division() {
    if (this.number2 != 0){
      this.result = this.number1 / this.number2;
    } else {
      this.result = "Input Error!";
    }
  }
}
