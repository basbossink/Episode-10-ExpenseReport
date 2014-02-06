package expenseReport;

import java.util.Locale;

public class ExpenseReporter {
  ReportPrinter printer;
  private ExpenseReport report;

  public ExpenseReporter(ExpenseReport report) {
    this.report = report;
  }

  public void printReport(ReportPrinter printer) {
    this.printer = printer;
    report.totalUpExpenses();
    printExpensesAndTotals();
  }

  private void printExpensesAndTotals() {
    printHeader();
    printExpenses();
    printTotals();
  }

  private void printHeader() {
    printer.print("Expenses " + getDate() + "\n");
  }

  private void printExpenses() {
    for (Expense expense : report.getExpenses())
      printExpense(expense);
  }

  private void printExpense(Expense expense) {
    printer.print(String.format(Locale.US, "%s\t%s\t$%.02f\n",
            expense.isOverage() ? "X" : " ",
            expense.getName(),
            penniesToDollars(expense.getAmount())));
  }

  private void printTotals() {
    printer.print(String.format(Locale.US, "\nMeal expenses $%.02f",
      penniesToDollars(report.getMealExpenses())));
    printer.print(String.format(Locale.US, "\nTotal $%.02f",
      penniesToDollars(report.getTotal())));
  }

  private double penniesToDollars(int pennies) {
    return pennies / 100.0;
  }

  private String getDate() {
    return "9/12/2002";
  }

}
