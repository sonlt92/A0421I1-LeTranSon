import {Component, OnInit} from '@angular/core';
import {Service} from "../../interface/service";
import {ServiceService} from "../../services/ServiceService";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-list-service',
  templateUrl: './list-service.component.html',
  styleUrls: ['./list-service.component.css']
})
export class ListServiceComponent implements OnInit {
  msg: string = "";
  service!: Service[];
  size: number = 0;
  maxPage: number = 0;
  private readonly LiMIT: number = 2;
  pageNow: number = 1;

  constructor(private _serviceService: ServiceService,
              private _activeRouter: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.getAllService();
    this.getPageService(this.pageNow,this.LiMIT);
    this._activeRouter.queryParamMap.subscribe((param) => {
      console.log(param.get('msg'));
      if (param.get('msg') == "success") {
        this.msg = "successfully added new!"
      }
    })
  }

  getAllService() {
    this._serviceService.getAllService().subscribe((data) => {
      this.size = data.length;

      if (this.size % this.LiMIT != 0) {
        this.maxPage = Math.floor(this.size / this.LiMIT) + 1;
      } else {
        this.maxPage = this.size / this.LiMIT;
      }
    });
  };

  getPageService(page: number, limit: number) {
    this._serviceService.getPageService(page, limit).subscribe((data) => {
      this.service = data;
    })
  }

  delete(id: string, fullName: string) {
    this._serviceService.deleteService(id).subscribe(() => {
      // @ts-ignore
      document.getElementById('row' + id).remove();
      this.msg = "successfully deleted service " + fullName + "!";
    })
  }

  prevPage(page: number) {
    if (page == 0) {
      page = 1;
      this.getPageService(page, this.LiMIT);
    } else {
      this.getPageService(page, this.LiMIT);
      this.pageNow--;
    }
  }


  nextPage(page: number) {
    if (page > this.maxPage) {
      page = this.maxPage;
      this.getPageService(page, this.LiMIT);
    } else {
      this.getPageService(page, this.LiMIT);
      this.pageNow++;
    }
  }
}
