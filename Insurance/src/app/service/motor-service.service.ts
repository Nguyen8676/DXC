import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs/index";
import { environment } from 'src/environments/environment';
import { ApiResponse } from '../model/api.response';
import { Motor } from '../model/Motor.model';
@Injectable({
  providedIn: 'root'
})
export class MotorServiceService {

  constructor(private http: HttpClient) { }

  private baseUrl: string = environment.baseUrl + '/api/motor';

  getMotors() : Observable<any> {
    return this.http.get<any>(this.baseUrl+'/getall-motor');
  }
}
