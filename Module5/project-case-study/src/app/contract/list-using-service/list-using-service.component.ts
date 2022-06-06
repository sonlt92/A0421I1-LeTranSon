import {Component, OnInit} from '@angular/core';
import {Contract} from "../../interface/contract";
import {ContractService} from "../../services/ContractService";
import {ContractDetailService} from "../../services/ContractDetailService";
import {DetailContract} from "../../interface/detailContract";


@Component({
  selector: 'app-list-using-service',
  templateUrl: './list-using-service.component.html',
  styleUrls: ['./list-using-service.component.css']
})
export class ListUsingServiceComponent implements OnInit {
  contracts!: Contract[];
  contractDetails!: DetailContract[];
  size: number = 0;
  maxPage: number = 0;
  private readonly LiMIT: number = 2;
  pageNow: number = 1;

  constructor(private _contractDetailService: ContractDetailService,
              private _contractService: ContractService) {
  }

  ngOnInit(): void {
    this.getAllService();
    this.getAllContract();
    this.getPageContract(this.pageNow, this.LiMIT)
  }

  getAllContract() {
    this._contractService.getAllContract().subscribe((data) => {
      this.size = data.length;

      if (this.size % this.LiMIT != 0) {
        this.maxPage = Math.floor(this.size / this.LiMIT) + 1;
      } else {
        this.maxPage = this.size / this.LiMIT;
      }
    })
  }

  getPageContract(page: number, limit: number) {
    this._contractService.getPageContract(page, limit).subscribe((data) => {
      this.contracts = data;
    })
  }

  getAllService() {
    this._contractDetailService.getAllContractDetail().subscribe((data) => {
      this.contractDetails = data;
    })
  }

  prevPage(page: number) {
    if (page == 0) {
      page = 1;
      this.getPageContract(page, this.LiMIT);
    } else {
      this.getPageContract(page, this.LiMIT);
      this.pageNow--;
    }
  }


  nextPage(page: number) {
    if (page > this.maxPage) {
      page = this.maxPage;
      this.getPageContract(page, this.LiMIT);
    } else {
      this.getPageContract(page, this.LiMIT);
      this.pageNow++;
    }
  }

}
