
import { Motor } from "./Motor.model";
export class Claim {
  id: any;
  claimNo: string;
  policyNo: string;
  dateOccurred: any;
  reserveCurrency: any;
  reserveAmount: any;
  status: any;
  motor: Motor;
  constructor(){}
}