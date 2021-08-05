import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs/index";
import { Claim } from '../model/Claim.model';
import { environment } from 'src/environments/environment';
import { ApiResponse } from '../model/api.response';
@Injectable({
  providedIn: 'root'
})
export class ClaimServiceService {

  constructor(private http: HttpClient) {
    
  }
  private baseUrl: string = environment.baseUrl + '/api/claim';
  
  getClaims() : Observable<any> {
    return this.http.get<any>(this.baseUrl+'/getall');
  }

  createClaim(claim: Claim): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.baseUrl+'/create-claim', claim);
  }

  getClaimByClaimNo(claimNo: any): Observable<any> {
    return this.http.get(this.baseUrl + '/get-claim/' + claimNo);
  }

  updateClaim(claim: Claim): Observable<any>{
    return this.http.post<ApiResponse>(this.baseUrl+'/update-claim', claim);
  }

  activeClaim(claimNo: any): Observable<any>{
    return this.http.get<ApiResponse>(this.baseUrl+'/active-claim/'+ claimNo);
  }

  createWithActive(claim: Claim): Observable<ApiResponse>{
    return this.http.post<ApiResponse>(this.baseUrl+'/create-active-claim', claim);
  }
}
