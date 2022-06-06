import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AttachService} from "../interface/attachService";

@Injectable({
  providedIn: "root"
})
export class AttachServiceService {
  private readonly API_URL = "http://localhost:3000/attachService"

  constructor(private _httpClient: HttpClient) {
  }

  getAllAttachService(): Observable<AttachService[]> {
    return this._httpClient.get<AttachService[]>(this.API_URL);
  }

  getAttachService(id:string): Observable<AttachService>{
    return this._httpClient.get<AttachService>(`${this.API_URL}/${id}`);
  }
}
