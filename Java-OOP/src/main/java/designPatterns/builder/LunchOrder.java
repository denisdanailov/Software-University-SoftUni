package designPatterns.builder;

public class LunchOrder {

    public static class Builder {

        private LunchOrder lunchOrder;

        private Builder() {
            this.lunchOrder = new LunchOrder();
        }

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder withSalad(String salad) {
            this.lunchOrder.setSalad(salad);
            return this;
        }

        public Builder withStarter(String starter) {
            this.lunchOrder.setStarter(starter);
            return this;
        }

        public Builder withMain(String main) {
            this.lunchOrder.setMain(main);
            return this;
        }

        public Builder withDesert(String desert) {
            this.lunchOrder.setDesert(desert);
            return this;
        }

        public Builder withRefreshment(String refreshment) {
            this.lunchOrder.setRefreshment(refreshment);
            return this;
        }

        public LunchOrder build() {
            return this.lunchOrder;
        }
    }

    private String salad;
    private String starter;
    private String main;
    private String desert;
    private String refreshment;

    private LunchOrder() {
    }

    public String getSalad() {
        return salad;
    }

    private void setSalad(String salad) {
        this.salad = salad;
    }

    public String getStarter() {
        return starter;
    }

    private void setStarter(String starter) {
        this.starter = starter;
    }

    public String getMain() {
        return main;
    }

    private void setMain(String main) {
        this.main = main;
    }

    public String getDesert() {
        return desert;
    }

    private void setDesert(String desert) {
        this.desert = desert;
    }

    public String getRefreshment() {
        return refreshment;
    }

    private void setRefreshment(String refreshment) {
        this.refreshment = refreshment;
    }
}
