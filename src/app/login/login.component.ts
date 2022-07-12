import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {HttpHeaders,HttpClient} from '@angular/common/http'
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';

const headerOptions = {

  headers: new HttpHeaders({

    'Content-Type': 'application/json',

    'Access-Control-Allow-Origin': '*',

    'Access-Control-Allow-Headers': 'Content-Type',

    'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, OPTIONS',

  }),

};
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public API_URL = environment.API_URL;

  title = 'brownlogistics';
  profileForm!: FormGroup;
  otpdata: any;
  enteredcode: any;
  driverId: any;
  isDisabled = true;
  numberdisable = true;
  errordisable = false;
  optvalid =false;
  loginCount: any;
  constructor(public form: FormBuilder,
              private http: HttpClient,
              private router: Router ) { }

  ngOnInit(): void {
    this.profileForm = this.form.group({
      mobileNumber: ['', [Validators.required]],
    });
  }
  valPhone() {
    let phone  = this.profileForm.get('mobileNumber')?.value;
    phone = phone.replace(/[^0-9+#]/g, "");
    // at least 10 in number
    if (phone.length >= 10) {
      // this.proper = phone;
      this.numberdisable = false;
      this.errordisable = false;
    } else {
      this.errordisable = true;
      this.numberdisable = true;
    }
  }

  otpget() {
      const payload = {
        "mobileNumber": this.profileForm.get('mobileNumber')?.value
      }
      // let body = new FormData();
      // body.append();
      // return this.http.post(this.API_URL + 'loginSubmit', loginRequest, headerOptions);

      // this.http.post<any>(`https://cvodev.azurewebsites.net/getOtp`,payload).subscribe(res=>{
      this.http.post<any>(this.API_URL + 'getOtp',payload, headerOptions).subscribe(res=>{
        const data = res;
        this.driverId = data.driverId;
        this.otpdata = data.otp;
       this. optvalid = true;
        if(this.otpdata == null) {
          this. optvalid = false;
          window.alert("Enter valid MobileNumber");
          // this.profileForm.get('mobileNumber')?.setValue('');
        }

      })
  }
  // this called every time when user changed the code
  onCodeChanged(code: string) {
 }

 // this called only if user entered full code
 onCodeCompleted(code: string) {
   this.enteredcode = code;
   this.isDisabled = false;
 }

 login(){
  const payload:any = {
    "mobileNumber": this.profileForm.get('mobileNumber')?.value,
    "otp":this.enteredcode
  }
  this.http.post<any>(this.API_URL + 'verifyOtp',payload, headerOptions).subscribe(res=>{
    const data:any = res;
    const id = data.driverId;
    this.loginCount = data.count
    if(id == null) {
      this.optvalid =false;
      window.alert("otp invalid");
   } else if( this.loginCount >= '1000'){
    window.alert("Your login more then 25 count");
   }else {
     this.router.navigate(
      ['/app-weekly-summary'],
      { queryParams: { driverId: this.driverId } }
    );
   }
  })
 }
}
