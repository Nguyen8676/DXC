import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Claim } from 'src/app/model/Claim.model';
import { ClaimServiceService } from 'src/app/service/claim-service.service';
import { SharedService } from 'src/app/shared/shared.service';
import { MotorServiceService } from 'src/app/service/motor-service.service';
import { Motor } from 'src/app/model/Motor.model';
import { MessageServiceService } from 'src/app/service/message-service.service';
import { Message } from 'src/app/model/Message.model';
import * as moment from 'moment';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbDate, NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { p } from '@angular/core/src/render3';
@Component({
  selector: 'app-update-claim',
  templateUrl: './update-claim.component.html',
  styleUrls: ['./update-claim.component.css']
})
export class UpdateClaimComponent implements OnInit {

  constructor(private claimService: ClaimServiceService, private shared: SharedService,private route: ActivatedRoute
    , private motorService: MotorServiceService, private messageService: MessageServiceService, private router: Router) { }
  foods = [
    {value: 'VND', viewValue: 'Vietnam Dong'},
    {value: 'SGD', viewValue: 'Singapore Dollar'},
    {value: 'USD', viewValue: 'US Dollar'}
  ];
  claim: Claim ;
  submitted = false;
  claimList: Claim[];
  currentId: any;
  date: any;
  motorList: Motor[];
  messages: Message[] = [];
  listMessages = [];
  alertMS: boolean=false;
  policyMS: boolean=false;
  dateMS: boolean=false;
  fieldMS: boolean=false;
  forceMS: boolean=false;
  reserveMS: boolean=false;
  insuredMS: boolean = false;

  datenullMS: boolean = false;
  policyNullMS: boolean = false;
  reserveCurrencyNullMS: boolean = false;
  reserveAmountNullMS: boolean = false;

  messageMandatory: string;
  messageDateInfuture: string;
  messagePolicyForce: string;
  messageNegative: string;
  messageCompareInsured: string;
  messagePolicyNotExist: string;

  claimNo: any;
  dateTemp: NgbDateStruct;

  allowCreated: boolean = false;
  currentMotor = {
    id: 0,
    policyNo: '',
    inceptionDate: '',
    expiryDate: '',
    engineNo: '',
    chassisNo: '',
    vehicleRegistrationNo: '',
    sumInsured: ''
  };
  @ViewChild('PolicyNo') policyNoElement: ElementRef;
  @ViewChild('date') dateOccurredElement: ElementRef;
  @ViewChild('reserveCurrency') reserveCurrencyElement: ElementRef;
  @ViewChild('reserveAmount') reserveAmountElement:ElementRef;
  ngOnInit() {
    this.getClaim();
    this.getMotors();
    
  }

  processDate() {
   
  }
  
  getClaim() {
    this.claim = new Claim();

    this.claimNo = this.route.snapshot.params['claimNo'];
    this.claimService.getClaimByClaimNo(this.claimNo)
      .subscribe(data => {
        this.claim = data;
        console.log(typeof(this.claim.dateOccurred.toString()));
        this.claim.policyNo = this.claim.motor.policyNo;
      }, error => console.log(error));
  }



  getMotors() {
    this.motorService.getMotors().subscribe(res => {
      this.motorList = res;
      console.log(this.motorList);
    });
  }

  checkPolicyExist() {
    for (let i = 0; i < this.motorList.length; i++){
      if (this.claim.policyNo === this.motorList[i].policyNo) {
        console.log("founded");
        this.policyNoElement.nativeElement.style.border = '';
        this.policyMS = false;
        this.alertMS = false;
        this.currentMotor = this.motorList[i];
        
        break;
      }
      else {
        this.policyNoElement.nativeElement.style.border = '2px solid red';
        this.policyMS = true;
        this.getErrMessage();
        this.alertMS = true;
      }
    }
  }
  
  checkValueNotEmpty() {
    if (this.fieldMS !== true && this.datenullMS !== true && this.policyNullMS !== true && this.reserveCurrencyNullMS !== true
      && this.reserveAmountNullMS !== true && this.alertMS !== true && this.policyMS !== true) {
      this.allowCreated = true;
      this.checkForceDate();
      // this.checkNegative();
    }
    else {
      this.allowCreated = false;
      
    }
    
  }

  checkValueEmptyClaim() {
    if (this.claim.policyNo === null || this.claim.policyNo === undefined || this.claim.policyNo === "") {
      this.policyNoElement.nativeElement.style.border = '2px solid red';
      this.policyNullMS = true;
      this.getErrMessage();
    }
    else {
      this.policyNoElement.nativeElement.style.border = '';
      this.policyNullMS = false;
    }
    if (this.claim.dateOccurred === null || this.claim.dateOccurred === undefined || this.claim.dateOccurred === "") {
      this.dateOccurredElement.nativeElement.style.border = '2px solid red';
      this.datenullMS = true;
      this.getErrMessage();
    }
    else {
      this.dateOccurredElement.nativeElement.style.border = '';
      this.datenullMS = false;
     
    }
    if (this.claim.reserveCurrency === null || this.claim.reserveCurrency === undefined || this.claim.reserveCurrency === "") {
      this.reserveCurrencyElement.nativeElement.style.border = '2px solid red';
      this.reserveCurrencyNullMS = true;
      this.getErrMessage();

    }
    else {
      this.reserveCurrencyElement.nativeElement.style.border = '';
      this.reserveCurrencyNullMS = false;

    }
    if (this.claim.reserveAmount === null || this.claim.reserveAmount === undefined || this.claim.reserveAmount === "") {
      this.reserveAmountElement.nativeElement.style.border = '2px solid red';
      this.reserveAmountNullMS = true;
      this.getErrMessage();
    }
    else {
      this.reserveAmountElement.nativeElement.style.border = '';
      this.reserveAmountNullMS = false;
    }
  }

  getErrMessage() {
    let self = this;
    self.messageService.getMessages().subscribe(res => {
      self.messages = res;
      for (let i = 0; i < self.messages.length; i++){
        self.listMessages.push(self.messages[i].errMessage);
      }
      if (this.policyMS === true) {
        this.allowCreated = false;
        self.messagePolicyNotExist = self.listMessages[0];
      }
      if (this.fieldMS === true || this.datenullMS === true || this.policyNullMS === true || this.reserveCurrencyNullMS === true || this.reserveAmountNullMS === true) {
        this.allowCreated = false;
        self.messageMandatory = self.listMessages[1];
      }
      if (this.dateMS === true) {
        this.allowCreated = false;
        self.messageDateInfuture = self.listMessages[2];
      }
      if (this.forceMS === true) {
        this.allowCreated = false;
        self.messagePolicyForce = self.listMessages[3];
      }
      if (this.reserveMS === true) {
        this.allowCreated = false;
        self.messageNegative = self.listMessages[4];
      }
      if (this.insuredMS === true) {
        this.allowCreated = false;
        self.messageCompareInsured = self.listMessages[5];
      }
    });
  }

  checkForceDate() {
    let date = this.claim.dateOccurred;
    if (!moment(this.claim.dateOccurred).isSameOrBefore(moment(this.currentMotor.expiryDate)) || !moment(this.claim.dateOccurred).isSameOrAfter(moment(this.currentMotor.inceptionDate))) {
      this.dateOccurredElement.nativeElement.style.border = '2px solid red';
        this.allowCreated = false;
        this.forceMS = true;
        this.getErrMessage();
        this.alertMS = true;
        
      }
    if (moment(this.claim.dateOccurred).isSameOrBefore(moment(this.currentMotor.expiryDate)) && moment(this.claim.dateOccurred).isSameOrAfter(moment(this.currentMotor.inceptionDate))) {
      this.dateOccurredElement.nativeElement.style.border = '';
        this.allowCreated = true;
        this.forceMS = false;
        this.alertMS = false;
        this.checkSumInsured();
      }  
  }

  checkSumInsured() {
    let reserveAmountNumber = Number(this.claim.reserveAmount);
    if (reserveAmountNumber > Number(this.currentMotor.sumInsured)) {
      this.allowCreated = false;
      this.reserveAmountElement.nativeElement.style.border = '2px solid red';
      this.insuredMS = true;
      this.getErrMessage();
      this.alertMS = true;
      
    }
    else  {
      this.reserveAmountElement.nativeElement.style.border = '';
      this.allowCreated = true;
      this.insuredMS = false;
      this.alertMS = false;
    }

  }

  checkNegative() {
    let reserveAmountNumber = Number(this.claim.reserveAmount);
     if (reserveAmountNumber < 0) {
      this.reserveAmountElement.nativeElement.style.border = '2px solid red';
      this.allowCreated = false;
      this.reserveMS = true;
      this.getErrMessage();
       this.alertMS = true;
       return false;
    }
    else {
      this.reserveAmountElement.nativeElement.style.border = '';
      this.allowCreated = true;
      this.reserveMS = false;
       this.alertMS = false;
       return true;
    }
  }

  onSubmit() {
    this.checkValueEmptyClaim();
    this.checkPolicyExist();
    this.checkValueNotEmpty();
    
    console.log(this.claim.reserveAmount);
    console.log(Number(this.claim.reserveAmount) > Number(this.currentMotor.sumInsured));
    console.log(this.allowCreated);
    if (this.allowCreated === true && this.checkNegative()===true) {
      this.claimService.updateClaim(this.claim)
      .subscribe(data => console.log(data), error => console.log(error));
      this.claim = new Claim();
      this.router.navigate(['']);
    }
  }

}
