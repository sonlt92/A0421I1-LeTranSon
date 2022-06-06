import {Component, OnInit} from '@angular/core';
import {Customer} from "../../interface/customer";
import {CustomerService} from "../../services/CustomerService";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  public customers!: Customer[];
  size: number = 0;
  maxPage: number = 0;
  private readonly LiMIT: number = 2;
  pageNow: number = 1;

  public msg: string = "";

  constructor(private _customerService: CustomerService, private _activeRouter: ActivatedRoute) {

  }

  ngOnInit(): void {
    this.getAllCustomer();
    this.getPageCustomer(this.pageNow, this.LiMIT);
    this._activeRouter.queryParamMap.subscribe((param) => {
      console.log(param.get('msg'));
      if (param.get('msg') == "success") {
        this.msg = "successfully added new!"
      }
    })
  }

  getAllCustomer() {
    this._customerService.getAllCustomer().subscribe((data) => {
      this.size = data.length;
      if (this.size % this.LiMIT != 0) {
        this.maxPage = Math.floor(this.size / this.LiMIT) + 1;
      } else {
        this.maxPage = this.size / this.LiMIT;
      }
    })
  }

  getPageCustomer(page: number, limit: number) {
    this._customerService.getPageCustomer(page, limit).subscribe((data) => {
      this.customers = data;
    })
  }

  delete(id: string, fullName: string) {
    this._customerService.deleteCustomer(id).subscribe(() => {
      // @ts-ignore
      document.getElementById('row' + id).remove();
      this.msg = "successfully deleted customer " + fullName + "!";
    })
  }

  prevPage(page: number) {
    if (page == 0) {
      page = 1;
      this.getPageCustomer(page, this.LiMIT);
    }else {
      this.getPageCustomer(page, this.LiMIT);
      this.pageNow--;
    }
  }


  nextPage(page: number) {
    if (page > this.maxPage) {
      page = this.maxPage;
      this.getPageCustomer(page, this.LiMIT);
    }else {
      this.getPageCustomer(page, this.LiMIT);
      this.pageNow++;
    }
  }
}
