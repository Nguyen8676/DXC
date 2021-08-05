import { Injectable } from '@angular/core';
import { Observable } from "rxjs/index";
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MessageServiceService {

  constructor(private http: HttpClient) {
    
  }

  private baseUrl: string = environment.baseUrl + '/api/message';

  getMessages() : Observable<any> {
    return this.http.get<any>(this.baseUrl+'/getall-message');
  }
  
}
