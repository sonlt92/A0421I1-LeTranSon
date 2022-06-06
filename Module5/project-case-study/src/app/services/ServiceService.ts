import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Service} from "../interface/service";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}

@Injectable({
  providedIn: "root"
})
export class ServiceService {
  private readonly API_URL = "http://localhost:3000/services";

  constructor(private _httpClient: HttpClient) {
  }

  getAllService(): Observable<Service[]> {
    return this._httpClient.get<Service[]>(this.API_URL);
  }

  getPageService(page: number, limit: number): Observable<Service[]> {
    const url = `${this.API_URL}?_page=${page}&_limit=${limit}`;
    return this._httpClient.get<Service[]>(url);
  }

  getServiceById(id: string): Observable<Service> {
    const url = `${this.API_URL}/${id}`;
    return this._httpClient.get<Service>(url);
  }

  addNewService(service: Service): Observable<any> {
    return this._httpClient.post(this.API_URL, service, httpOptions);
  }

  updateService(service: Service): Observable<any> {
    const url = `${this.API_URL}/${service.id}`
    return this._httpClient.put(url, service, httpOptions);
  }

  deleteService(id: string): Observable<any> {
    const url = `${this.API_URL}/${id}`;
    return this._httpClient.delete(url, httpOptions);
  }
}
