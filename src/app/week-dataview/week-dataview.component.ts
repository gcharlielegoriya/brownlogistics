import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
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
  selector: 'app-week-dataview',
  templateUrl: './week-dataview.component.html',
  styleUrls: ['./week-dataview.component.css'],
})

export class WeekDataviewComponent implements OnInit {
  public API_URL = environment.API_URL;
  userdata:any
  userdata1:[] | undefined;
  frieghtId: any;
  amountData: any;
  constructor(private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient, private activatedRoute: ActivatedRoute) {
      this.activatedRoute.queryParams.subscribe(params => {
        this.driverId = params['driverId'];
    });
    }
  driverId(driverId: any) {
    throw new Error('Method not implemented.');
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.frieghtId = params['frieghtId'];
  });

  this.getData();
  }

  getData() {
    this.http.post<any>(this.API_URL + 'getWeekDetails', {frieghtId: this.frieghtId},headerOptions).subscribe(res=>{
        this.userdata = res;
        this.amountData = this.userdata.calcAndPaydesc;
      })
  }

  goback() {
    this.router.navigate(
      ['/getdatalist'],
      { queryParams: { driverId: this.driverId } }
    );
  }

}
