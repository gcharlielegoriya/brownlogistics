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
  selector: 'app-getDetailWeek',
  templateUrl: './getDetailWeek.component.html',
  styleUrls: ['./getDetailWeek.component.css']
})

export class GetDetailWeekComponent implements OnInit {
  approvedata: any;
  driverId: any;
  tripListData:any;
  searchText:any;  date:any ;
  status: any;
  public API_URL = environment.API_URL;
  amountData: any;

  constructor( private router: Router,
                  private http: HttpClient,
                  private activatedRoute: ActivatedRoute) {
                    this.activatedRoute.queryParams.subscribe(params => {
                      this.driverId = params['driverId'];
                      this.status= params['status']
                  });
                  }

  ngOnInit() {
    this.http.post<any>(this.API_URL + 'currentWeekSummaryData',{driverId:this.driverId},headerOptions).subscribe(res=>{
      this.approvedata= res.currentWkList;
      this.amountData = this.approvedata.calcAndPaydesc;
      if(this.status == "Unapproved") {
        this.tripListData= this.approvedata.filter( (book: { paidstatus: string; }) => book.paidstatus === "Unapproved");
      } else if(this.status == "Approved") {
        this.tripListData= this.approvedata.filter( (book: { paidstatus: string; }) => book.paidstatus === "Approved");
      } else {
        this.tripListData= this.approvedata;
        this.amountData = this.approvedata.calcAndPaydesc;
      }
    })
  }

  getTripDetails(id:any) {
    this.router.navigate(
      ['/weekdetails'],
      { queryParams: { frieghtId: id ,driverId: this.driverId } }
    );
  }

  goback() {
    this.router.navigate(
      ['/app-weekly-summary'],
      { queryParams: { driverId: this.driverId } }
    );
  }

}
