import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Contract} from "../interface/contract";

@Injectable({
  providedIn: "root"
})
export class ContractService {
  private readonly API_URL = "http://localhost:3000/contract"

  constructor(private _httpClient: HttpClient) {
  }

  getAllContract(): Observable<Contract[]> {
    return this._httpClient.get<Contract[]>(this.API_URL);
  }

  getPageContract(page: number, limit: number): Observable<Contract[]> {
    const url = `${this.API_URL}?_page=${page}&_limit=${limit}`;
    return this._httpClient.get<Contract[]>(url);
  }

  addNewContract(contract: Contract): Observable<any> {
    return this._httpClient.post(this.API_URL, contract);
  }
}
