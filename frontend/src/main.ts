import { bootstrapApplication } from '@angular/platform-browser';
import { provideRouter, RouterOutlet, Routes } from '@angular/router';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  template: `<h1>Computer Parts Store</h1><router-outlet></router-outlet>`
})
class AppComponent {}

@Component({selector: 'products-page', standalone: true, template: '<p>Products list view</p>'})
class ProductsPage {}
@Component({selector: 'cart-page', standalone: true, template: '<p>Cart page</p>'})
class CartPage {}
@Component({selector: 'checkout-page', standalone: true, template: '<p>Checkout page</p>'})
class CheckoutPage {}
@Component({selector: 'admin-page', standalone: true, template: '<p>Admin dashboard</p>'})
class AdminPage {}

const routes: Routes = [
  { path: '', component: ProductsPage },
  { path: 'cart', component: CartPage },
  { path: 'checkout', component: CheckoutPage },
  { path: 'admin', component: AdminPage }
];

bootstrapApplication(AppComponent, { providers: [provideRouter(routes)] });
