import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ApiResponse } from 'src/app/model/api.response';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import * as $ from "jquery";
import { ClaimServiceService } from 'src/app/service/claim-service.service';
import { Claim } from 'src/app/model/Claim.model';
import { SharedService } from 'src/app/shared/shared.service';
import { FileService } from 'src/app/service/file.service';
import {TranslateService} from '@ngx-translate/core';
@Component({
  selector: 'app-claim-list',
  templateUrl: './claim-list.component.html',
  styleUrls: ['./claim-list.component.css']
})
export class ClaimListComponent implements OnInit {
  @ViewChild('buttonUpdate') btnUpdateElement: ElementRef;
  claims: Observable<ApiResponse>;
  listClaim: Claim[];
  status: any;
  allowUpdate: boolean = false;
  public images: any = [];
  constructor(private claimService: ClaimServiceService,private shared:SharedService, private fileservice:FileService,private translate: TranslateService
    , private router: Router) {}

  ngOnInit() {
    // this.getListClaim();
    setTimeout(()=>{                           // <<<---using ()=> syntax
      this.getListClaim();
    }, 1000);
    this.getImage();
  }

  getImage() {
    this.fileservice.getImages().subscribe(response => {
      this.images = response;
    })
  }

  getListClaim() {
    this.claimService.getClaims().subscribe(res => {
      this.listClaim = res;
      this.listClaim.sort((a, b) => a.id < b.id ? -1 : a.id > b.id ? 1 : 0);
      console.log(this.listClaim);
      this.shared.setDataToPass(this.listClaim);
      this.checkStatus();
    });
  }


  getClaimByClaimNo(i: any) {
    if (this.listClaim[i].status === 'Pending') {
      this.router.navigate(['update', this.listClaim[i].claimNo]);
      console.log(this.listClaim[i].claimNo);
    }
  }

  activeClaim(i: any) {
    if (this.listClaim[i].status === 'Pending') {
      this.claimService.activeClaim(this.listClaim[i].claimNo).subscribe(data => console.log(data), error => console.log(error));
      setTimeout(()=>{                           // <<<---using ()=> syntax
        this.getListClaim();
      }, 0);
    }
    else {
    }
  
  }

  checkStatus() {
    for (let i = 0; i < this.listClaim.length; i++){
      if (this.listClaim[i].status === false) {
        this.listClaim[i].status = 'Pending';
      }
      else {
        this.listClaim[i].status = 'Active';  
      }
    }
  }
}
