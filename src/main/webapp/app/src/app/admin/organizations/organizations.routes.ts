import { Routes } from '@angular/router';
import { OrganizationsListComponent } from './organizations-list.component';
import { OrganizationFormComponent } from './organization-form.component';

export const ORGS_ROUTES: Routes = [
  { path: '', component: OrganizationsListComponent },
  { path: 'new', component: OrganizationFormComponent },
  { path: ':id', component: OrganizationFormComponent }
];
