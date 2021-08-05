import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs/index";
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class FileService {

  constructor(private http: HttpClient) { }
  private baseUrl: string = environment.baseUrl + '/api/claim';
  getImages(): Observable<any>{
    return this.http.get(this.baseUrl + '/getImages');
  }
}
