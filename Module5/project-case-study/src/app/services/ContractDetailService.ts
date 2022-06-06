import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {DetailContract} from "../interface/detailContract";

@Injectable({
  providedIn: "root"
})
export class ContractDetailService {
  private readonly API_URL = "http://localhost:3000/contractDetails"

  constructor(private _httpClient: HttpClient) {
  }

  addNewContract(detailContract: DetailContract): Observable<any> {
    return this._httpClient.post(this.API_URL, detailContract);
  }

  getAllContractDetail(): Observable<DetailContract[]>{
    return this._httpClient.get<DetailContract[]>(this.API_URL);
  }
}
