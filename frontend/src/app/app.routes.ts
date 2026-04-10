import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: '', loadComponent: () => import('./features/products/products.page').then(m => m.ProductsPage) },
  { path: 'cart', loadComponent: () => import('./features/cart/cart.page').then(m => m.CartPage) },
  { path: 'checkout', loadComponent: () => import('./features/checkout/checkout.page').then(m => m.CheckoutPage) },
  { path: 'admin', loadComponent: () => import('./features/admin/admin.page').then(m => m.AdminPage) }
];
