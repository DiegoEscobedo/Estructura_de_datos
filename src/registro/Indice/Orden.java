package registro.Indice;

public class Orden {
    protected String id;
    protected String date;
    protected String mode;
    protected String customer_id;
    protected String status;
    protected String total;
    protected String sales_rep_id;
    protected String promotion_id;

    public Orden() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSales_rep_id() {
        return sales_rep_id;
    }

    public void setSales_rep_id(String sales_rep_id) {
        this.sales_rep_id = sales_rep_id;
    }

    public String getPromotion_id() {
        return promotion_id;
    }

    public void setPromotion_id(String promotion_id) {
        this.promotion_id = promotion_id;
    }

    @Override
    public String toString() {
        return "Orden{" +
                "id=" + id + ' ' +
                ", date=" + date +
                ", mode=" + mode +
                ", customer_id=" + customer_id +
                ", status=" + status +
                ", total=" + total +
                ", sales_rep_id=" + sales_rep_id +
                ", promotion_id=" + promotion_id +
                '}';
    }
}
