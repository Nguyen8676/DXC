import { Injectable } from '@angular/core';
import { Claim } from '../model/Claim.model';
@Injectable({
  providedIn: 'root'
})
export class SharedService {
  claim: Claim[] = [];
  constructor() {
    
  }

  setDataToPass(data) {
    this.claim = data;
  }
  getDataPassed() {
    return this.claim;
  }
}
