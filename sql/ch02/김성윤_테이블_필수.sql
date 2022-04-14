
     
    CREATE TABLE ORDERS(
         ORDER_ID NUMBER(12,0)
        ,ORDER_DATE DATE
        ,ORDER_MODE VARCHAR2(8 BYTE)
        ,CUSTOMER_ID NUMBER(6,0)
        ,ORDER_STATUS NUMBER(2,0)
        ,ORDER_TOTAL NUMBER(8,2) default 0
        ,SALE_REP_ID NUMBER(6,0)
        ,PROMOTION_ID NUMBER(6,0)
        ,constraint pk_order primary key(order_id)
        ,constraint ck_order_mode check(order_mode in('direct','online'))

    );
    
    
    
    
    
    CREATE TABLE ORDER_ITEMS(
         ORDER_ID NUMBER(12,0) 
        ,LINE_ITEM_ID NUMBER(3,0)
        ,PRODUCT_ID NUMBER(3,0)
        ,UNIT_PRICE NUMBER(8,2) default 0
        ,QUANTITY NUMBER(8,0) default 0
        ,CRATE_DT DATE default sysdate
        ,constraint pk_order_items primary key (order_id,line_item_id)
        
    
    );
    