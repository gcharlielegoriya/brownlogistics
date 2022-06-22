import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {HttpClient} from '@angular/common/http'
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  title = 'brownlogistics';
  profileForm!: FormGroup;
  otpdata: any;
  enteredcode: any;
  driverId: any;
  isDisabled = true;
  numberdisable = true;
  constructor(public form: FormBuilder,
              private http: HttpClient,
              private router: Router ) { }

  ngOnInit(): void {
    this.profileForm = this.form.group({
      mobileNumber: ['', [Validators.required]],
    });
  }

  keyPress(event: any) {
    const pattern = /[0-9\+\-\ ]/;

    let inputChar = String.fromCharCode(event.charCode);
    if (event.keyCode != 8 && !pattern.test(inputChar)) {
      event.preventDefault();
    }
    this.numberdisable = false;
  }

  otpget() {
      console.log(this.profileForm.value)
      const payload = {
        "mobileNumber": this.profileForm.get('mobileNumber')?.value
      }
      // let body = new FormData();
      // body.append();
      this.http.post<any>(`http://localhost:7777/getOtp`,payload).subscribe(res=>{
        console.log(res);
        const data = res;
        this.driverId = data.driverId;
        this.otpdata = data.otp;
        if(this.otpdata == null) {
          window.alert("Enter valid MobileNumber");
          // this.profileForm.get['mobileNumber'].setValue('');
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
   if(this.enteredcode == this.otpdata) {
    this.router.navigate(
      ['/app-weekly-summary'],
      { queryParams: { driverId: this.driverId } }
    );
   } else {
     window.alert("otp invalid");
   }
 }
}
