import { Component, ElementRef, ViewChild, Input, Output, EventEmitter, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { COMMA, ENTER} from '@angular/cdk/keycodes';
import { MatAutocompleteSelectedEvent, MatAutocomplete} from '@angular/material/autocomplete';
import { MatChipInputEvent} from '@angular/material/chips';
import { Observable} from 'rxjs';
import { map, startWith} from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';


export interface Tile {
  color: string;
  cols: number;
  rows: number;
  text: string;
}

export interface Disease{
  id: number;
	diseaseName: string;
	symptom: string;
	diseaseDescription: string;
	durationOfDisease: number;
}

export interface ConsultationForm{
  patientName: any;
  patientGender: any;
  patientDOB: any;
  patientBloodGroup: any;
  patientHeight: any;
  patientWeight: any;
  patientEmailAddress: any;
  patientPhoneNumber: any;
} 

export interface Medicine{
  id: number;
  medicineName: string;
  diseaseName: string;
  symptomName: string;
  treatmentDescription: string;
  numberOfTimesPrescribed: number;
  vendorName: string;
  durationToUse: number;
}

export interface Symptom{
  id: number;
  symptomName: string;
	symptomDescription: string;
	durationOfSymptom: number;
}

export interface TreatmentProtocol{
  id: string;
  diseaseName: string;
  symptomName: string;
  medicineName: string;
  medicineDescription: string;
  medicineDuration: number;
}


@Component({
  selector: 'my-doctor-body',
  templateUrl: './my-doctor-body.component.html',
  styleUrls: ['./my-doctor-body.component.css']
})
export class MyDoctorBodyComponent implements OnInit {


  isLinear = true;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;
  
  httpHeader: HttpHeaders;

  constructor(private _formBuilder: FormBuilder,private http: HttpClient) {
    this.filteredFruits = this.fruitCtrl.valueChanges.pipe(
      startWith(null),
      map((fruit: string | null) => fruit ? this._filter(fruit) : this.symptomsList.slice()));
   }

  ngOnInit(): void {
    this.firstFormGroup = this._formBuilder.group({
      //firstCtrl: ['', Validators.required]
      patientName: [''],
      patientGender: [''],
      patientDOB: [''],
      patientBloodGroup: [''],
      patientHeight: [''],
      patientWeight: [''],
      patientEmailAddress: [''],
      patientPhoneNumber: ['']
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: [''],
      patientDisease: ['']
    });
    this.thirdFormGroup = this._formBuilder.group({
      thirdCtrl: [''],
      underLyingConditions:[''],
      anySurgeries:[''],
      anyMedications:[''],
      otherDetails:['']
    });
  }

  tiles: Tile[] = [
    {text: 'One', cols: 3, rows: 1, color: '#eee'},
    {text: 'Two', cols: 4, rows: 2, color: 'lightgreen'},
    {text: 'Three', cols: 3, rows: 1, color: 'lightpink'},
    {text: 'Four', cols: 2, rows: 1, color: '#DDBDF1'},
  ];

  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]); 

  phoneFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]); 

  gender: string[] = ['Male', 'Female', 'Other'];

  startDate = new Date(1975, 0, 1);

  showFiller = false;

  value = 'Clear me';

  visible = true;
  selectable = true;
  removable = true;
  separatorKeysCodes: number[] = [ENTER, COMMA];
  fruitCtrl = new FormControl();
  filteredFruits: Observable<string[]>;
  fruits: string[]= new Array();
  diseases: Disease[] = this.getDiseaseData();
  diseaseList: string[]=new Array();
  allDiseases: string[] = this.diseaseList;
  consultationFormData: any = new FormData();
  patientInformation: ConsultationForm;
  patientArray: string[]= new Array();
  patientDiseaseArray: string[] = new Array();
  medicines: Medicine[]= new Array();
  symptoms: Symptom[]= this.getSymptomData();
  symptomsList: string[] = new Array();
  treamentProtocol : TreatmentProtocol[] = new Array();

  bloodGroup: string[] =['A+','A-','B+','B-','AB+','AB-','O+','O-'];

  @ViewChild('diseaseInput') diseaseInput: ElementRef<HTMLInputElement>;
  @ViewChild('auto') matAutocomplete: MatAutocomplete;
 

  add(event: MatChipInputEvent): void {
    const input = event.input;
    const value = event.value;

    // Add our fruit
    if ((value || '').trim()) {
      this.fruits.push(value.trim());
    }

    // Reset the input value
    if (input) {
      input.value = '';
    }

    this.fruitCtrl.setValue(null);
  }

  remove(fruit: string): void {
    const index = this.fruits.indexOf(fruit);

    if (index >= 0) {
      this.fruits.splice(index, 1);
    }
  }

  selected(event: MatAutocompleteSelectedEvent): void {
    this.fruits.push(event.option.viewValue);
    this.diseaseInput.nativeElement.value = '';
    this.fruitCtrl.setValue(null);
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.symptomsList.filter(fruit => fruit.toLowerCase().indexOf(filterValue) === 0);
  }

  
  public getDiseaseData(){
    this.http.get<Disease[]>('http://localhost:8080/list-diseases').subscribe(data => {
     this.diseases = data;
  }); 
  return this.diseases;
}


public getDiseasesList(): string[]{

  while(this.diseaseList.length!=0){
  this.diseaseList.pop();
}
  for( let  i of Object.keys(this.diseases ))
{
  var element=this.diseases[i];
   this.diseaseList.push(element.diseaseName);
}
return this.diseaseList;
}

public getPatientData(){
   
   var patientData={
    patientName: this.firstFormGroup.controls['patientName'].value,
    patientGender: this.firstFormGroup.controls['patientGender'].value,
    patientDOB: this.firstFormGroup.controls['patientDOB'].value,
    patientBloodGroup: this.firstFormGroup.controls['patientBloodGroup'].value,
    patientHeight: this.firstFormGroup.controls['patientHeight'].value,
    patientWeight: this.firstFormGroup.controls['patientWeight'].value,
    patientEmailAddress: this.firstFormGroup.controls['patientEmailAddress'].value,
    patientPhoneNumber: this.firstFormGroup.controls['patientPhoneNumber'].value
  };
  this.patientInformation=patientData;
  this.getDiseasesList();
  this.getSymptomsList();
  this.patientArray.push(this.patientInformation.patientName);
  this.patientArray.push(this.patientInformation.patientGender);
  this.patientArray.push(this.patientInformation.patientDOB);
  this.patientArray.push(this.patientInformation.patientBloodGroup);
  this.patientArray.push(this.patientInformation.patientHeight);
  this.patientArray.push(this.patientInformation.patientWeight);
  this.patientArray.push(this.patientInformation.patientEmailAddress);
  this.patientArray.push(this.patientInformation.patientPhoneNumber);
}

public getMedicalHistory(){
  var medicalHistory={
        underLyingConditions: this.thirdFormGroup.value.underLyingConditions,
        anySurgeries: this.thirdFormGroup.value.anySurgeries,
        anyMedications: this.thirdFormGroup.value.anyMedications,
        otherDetails: this.thirdFormGroup.value.otherDetails

  };
  if(medicalHistory.anySurgeries=='') {
    this.patientArray.push("None");
  }
  else{
    this.patientArray.push(medicalHistory.underLyingConditions);
  }
  if(medicalHistory.underLyingConditions==''){
    this.patientArray.push("None");
  }
  else{
    this.patientArray.push(medicalHistory.anySurgeries);
  }
  if(medicalHistory.anyMedications==''){
    this.patientArray.push("None");
  }
  else{
    this.patientArray.push(medicalHistory.anyMedications);
  }
  if(medicalHistory.otherDetails==''){
    this.patientArray.push("None");
  }
  else{
    this.patientArray.push(medicalHistory.otherDetails);
  }
  this.getTreatmentInformation();
  this.getMedicineInformation();
  //this.getTreatmentInformation();
}  

public getMedicineInformation(){
  let url='http://localhost:8080/list-medicine-by-disease?diseaseName='+this.fruits[0];
  this.http.get<Medicine[]>(url).subscribe(data => {
   this.medicines = data;
}); 
let medArr:Medicine[] = new Array();

if(medArr.length==0){
  medArr.push(this.medicines[0]);
}

  for(let i=0,j=1; i<this.medicines.length,j<this.medicines.length-1;i++,j++){

    if(this.medicines[i].medicineName==this.medicines[j].medicineName){
      continue;
    }
    else{
      medArr.push(this.medicines[i]);
    }

}

this.medicines=new Array();
this.medicines=medArr;
console.log(medArr);
// console.log(this.medicines.filter((obj, pos, arr) => {
//   return arr.map(mapObj => mapObj["value"]).indexOf(obj["value"]) === pos;
// }));
return this.medicines;
}

public getSymptomData(){
  this.http.get<Symptom[]>('http://localhost:8080/list-symptoms').subscribe(data => {
   this.symptoms = data;
}); 
return this.symptoms;
}

public getSymptomsList(): string[]{

  while(this.symptomsList.length!=0){
  this.symptomsList.pop();
}
  for( let  i of Object.keys(this.symptoms))
{
  var element=this.symptoms[i];
   this.symptomsList.push(element.symptomName);
}
return this.symptomsList;
}

public clearForms(){
  while(this.patientArray.length!=0){
    this.patientArray.pop();
  }
}

public getTreatmentInformation(){
  let url='http://localhost:8080/get-treatment-protocol?symptomName='+this.fruits[0];
  this.http.get<TreatmentProtocol[]>(url).subscribe(data => {
   this.treamentProtocol = data;
}); 
let medArr:TreatmentProtocol[] = new Array();

if(medArr.length==0){
  medArr.push(this.treamentProtocol[0]);
}

  for(let i=0,j=1; i<this.treamentProtocol.length,j<this.treamentProtocol.length-1;i++,j++){

    if(this.treamentProtocol[i].medicineName==this.treamentProtocol[j].medicineName){
      continue;
    }
    else{
      medArr.push(this.treamentProtocol[i]);
    }

}

this.treamentProtocol=new Array();
this.treamentProtocol=medArr;
console.log(medArr);
// console.log(this.treamentProtocol.filter((obj, pos, arr) => {
//   return arr.map(mapObj => mapObj["value"]).indexOf(obj["value"]) === pos;
// }));
return this.treamentProtocol;
}

}
