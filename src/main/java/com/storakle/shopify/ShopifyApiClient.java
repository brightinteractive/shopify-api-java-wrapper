package com.storakle.shopify;

import com.storakle.shopify.domain.*;
import feign.Param;
import feign.RequestLine;

import java.time.LocalDateTime;

public interface ShopifyApiClient {
    int MAXIMUM_RETURNED_RESULTS = 250;

    @RequestLine("GET /admin/customers.json?limit={limit}&since_id={since-id}&page={page}&fields={fields}")
    CustomerList getCustomers(@Param("limit") Integer limit, @Param("since-id") String sinceId, @Param("page") Integer page, @Param("fields") String fields);

    @RequestLine("GET /admin/customers/count.json")
    Count getCustomersCount();

    @RequestLine("GET /admin/custom_collections.json?limit={limit}&since_id={since-id}&page={page}&fields={fields}")
    CustomCollectionList getCustomCollections(@Param("limit") Integer limit, @Param("since-id") String sinceId, @Param("page") Integer page, @Param("fields") String fields);

    @RequestLine("GET /admin/custom_collections/count.json")
    Count getCustomCollectionsCount();

    @RequestLine("GET /admin/smart_collections.json?limit={limit}&since_id={since-id}&page={page}&fields={fields}")
    SmartCollectionList getSmartCollections(@Param("limit") Integer limit, @Param("since-id") String sinceId, @Param("page") Integer page, @Param("fields") String fields);

    @RequestLine("GET /admin/smart_collections/count.json")
    Count getSmartCollectionsCount();

    @RequestLine("GET /admin/products.json?limit={limit}&since_id={since-id}&page={page}&fields={fields}")
    ProductList getProducts(@Param("limit") Integer limit, @Param("since-id") String sinceId, @Param("page") Integer page, @Param("fields") String fields);

    @RequestLine("GET /admin/products/count.json")
    Count getProductsCount();

    @RequestLine("GET /admin/collects.json?limit={limit}&page={page}&fields={fields}")
    CollectList getCollects(@Param("limit") Integer limit, @Param("page") Integer page, @Param("fields") String fields);

    @RequestLine("GET /admin/collects/count.json")
    Count getCollectsCount();

    @RequestLine("GET /admin/orders.json?" +
            "ids={ids}" +
            "&limit={limit}" +
            "&page={page}" +
            "&since_id={since-id}" +
            "&created_at_min={created_at_min}" +
            "&created_at_max={created_at_max}" +
            "&updated_at_min={updated_at_min}" +
            "&updated_at_max={updated_at_max}" +
            "&processed_at_min={processed_at_min}" +
            "&processed_at_max={processed_at_max}" +
            "&status={status}" +
            "&financial_status={financial_status}" +
            "&fulfillment_status={fulfillment_status}" +
            "&fields={fields}"
    )
    OrderList getOrders(@Param("ids") String ids,
                        @Param("limit") Integer limit,
                        @Param("page") Integer page,
                        @Param("since-id") String sinceId,
                        @Param("created_at_min") LocalDateTime createdAtMin,
                        @Param("created_at_max") LocalDateTime createdAtMax,
                        @Param("updated_at_min") LocalDateTime updatedAtMin,
                        @Param("updated_at_max") LocalDateTime updatedAtMax,
                        @Param("processed_at_min") LocalDateTime processedAtMin,
                        @Param("processed_at_max") LocalDateTime processedAtMax,
                        @Param("status") OrderStatus status,
                        @Param("financial_status") FinancialStatus financialStatus,
                        @Param("fulfillment_status") FufillmentStatus fufillmentStatus,
                        @Param("fields") String fields);

    @RequestLine("GET /admin/orders/count.json?" +
            "created_at_min={created_at_min}" +
            "&created_at_max={created_at_max}" +
            "&updated_at_min={updated_at_min}" +
            "&updated_at_max={updated_at_max}" +
            "&status={status}" +
            "&financial_status={financial_status}" +
            "&fulfillment_status={fulfillment_status}"
    )
    Count getOrdersCount(@Param("created_at_min") LocalDateTime createdAtMin,
                         @Param("created_at_max") LocalDateTime createdAtMax,
                         @Param("updated_at_min") LocalDateTime updatedAtMin,
                         @Param("updated_at_max") LocalDateTime updatedAtMax,
                         @Param("status") OrderStatus status,
                         @Param("financial_status") FinancialStatus financialStatus,
                         @Param("fulfillment_status") FufillmentStatus fufillmentStatus);


    @RequestLine("GET /admin/webhooks.json?limit={limit}&since_id={since-id}&page={page}&fields={fields}")
    WebhookList getWebhooks(@Param("limit") Integer limit, @Param("since-id") String sinceId, @Param("page") Integer page, @Param("fields") String fields);

    @RequestLine("GET /admin/webhooks/count.json")
    Count getWebhooksCount();

    @RequestLine("GET /admin/orders/{orderId}/transactions.json?limit={limit}&since_id={since-id}")
    TransactionList getTransactions(@Param("orderId") String orderId, @Param("limit") Integer limit, @Param("since-id") String sinceId);

    @RequestLine("GET /admin/orders/{orderId}/transactions/count.json")
    Count getTransactionsCount(@Param("orderId") String orderId);

    @RequestLine("POST /admin/webhooks.json")
    Webhook createWebhook(Webhook webhook);
}
