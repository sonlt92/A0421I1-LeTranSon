import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BenhAnModel} from '../models/benhAnModel';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ComponentService {
  API_URL = 'http://localhost:8080/benhan';

  constructor(private httpClient: HttpClient) {
  }

  getList(): Observable<BenhAnModel[]> {
    return this.httpClient.get<BenhAnModel[]>(this.API_URL);
  }

  findById(id: number): Observable<BenhAnModel> {
    return this.httpClient.get<BenhAnModel>(this.API_URL + '/' + id);
  }

  updateBenhAn(benhAnModel: BenhAnModel): Observable<void> {
    console.log(benhAnModel);
    return this.httpClient.patch<void>(this.API_URL + '/' + benhAnModel.id, benhAnModel);
  }

  deleteBenhAn(id: string): Observable<void> {
    return this.httpClient.delete<void>(this.API_URL + '/' + id);
  }

  // createBenhAn(benhAnModel: BenhAnModel): Observable<BenhAnModel>{
  //   console.log(benhAnModel);
  //   return this.httpClient.post<BenhAnModel>(this.API_URL, benhAnModel);
  // }

}
