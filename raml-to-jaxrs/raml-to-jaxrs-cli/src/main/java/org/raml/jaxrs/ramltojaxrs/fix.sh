#!/usr/bin/env bash

# manually fix up generated code..
grep --files-with-matches "extends Reservation" java/com/triplake/adapter/kmapi/jaxrs/api/model/*.java | xargs sed -i 's/ DivideSplitDetailsType getDivideSplitDetails/Reservation.DivideSplitDetailsType getDivideSplitDetails/g'
grep --files-with-matches "extends Reservation" java/com/triplake/adapter/kmapi/jaxrs/api/model/*.java | xargs sed -i 's/ FlightsRangeType getFlightsRange/Reservation.FlightsRangeType getFlightsRange/g'
grep --files-with-matches "extends Reservation" java/com/triplake/adapter/kmapi/jaxrs/api/model/*.java | xargs sed -i 's/setDivideSplitDetails.DivideSplitDetailsType/setDivideSplitDetails\(Reservation.DivideSplitDetailsType/g'
grep --files-with-matches "extends Reservation" java/com/triplake/adapter/kmapi/jaxrs/api/model/*.java | xargs sed -i 's/setFlightsRange.FlightsRangeType/setFlightsRange\(Reservation.FlightsRangeType/g'

# reservation impl leaves
sed -i 's/AddPreReservedSeatsResponse.DivideSplitDetailsType/Reservation.DivideSplitDetailsType/g'             java/com/triplake/adapter/kmapi/jaxrs/api/model/AddPreReservedSeatsResponseImpl.java
sed -i 's/AddPreReservedSeatsResponse.FlightsRangeType/Reservation.FlightsRangeType/g'                         java/com/triplake/adapter/kmapi/jaxrs/api/model/AddPreReservedSeatsResponseImpl.java

sed -i 's/AncillariesAddResponse.DivideSplitDetailsType/Reservation.DivideSplitDetailsType/g'             java/com/triplake/adapter/kmapi/jaxrs/api/model/AncillariesAddResponseImpl.java
sed -i 's/AncillariesAddResponse.FlightsRangeType/Reservation.FlightsRangeType/g'                         java/com/triplake/adapter/kmapi/jaxrs/api/model/AncillariesAddResponseImpl.java

sed -i 's/CreateReservationResponse.DivideSplitDetailsType/Reservation.DivideSplitDetailsType/g'             java/com/triplake/adapter/kmapi/jaxrs/api/model/CreateReservationResponseImpl.java
sed -i 's/CreateReservationResponse.FlightsRangeType/Reservation.FlightsRangeType/g'                         java/com/triplake/adapter/kmapi/jaxrs/api/model/CreateReservationResponseImpl.java

sed -i 's/GetReservationResponse.DivideSplitDetailsType/Reservation.DivideSplitDetailsType/g'             java/com/triplake/adapter/kmapi/jaxrs/api/model/GetReservationResponseImpl.java
sed -i 's/GetReservationResponse.FlightsRangeType/Reservation.FlightsRangeType/g'                         java/com/triplake/adapter/kmapi/jaxrs/api/model/GetReservationResponseImpl.java

sed -i "s/ FareBasisCodesType getFareBasisCodes/UnbrandedSegmentDetails.FareBasisCodesType getFareBasisCodes/g"      java/com/triplake/adapter/kmapi/jaxrs/api/model/BrandedSegmentDetails.java
sed -i "s/ AccountCodesType getAccountCodes/UnbrandedSegmentDetails.AccountCodesType getAccountCodes/g"              java/com/triplake/adapter/kmapi/jaxrs/api/model/BrandedSegmentDetails.java
sed -i "s/setFareBasisCodes.FareBasisCodesType/setFareBasisCodes(UnbrandedSegmentDetails.FareBasisCodesType/g"       java/com/triplake/adapter/kmapi/jaxrs/api/model/BrandedSegmentDetails.java
sed -i "s/setAccountCodes.AccountCodesType/setAccountCodes(UnbrandedSegmentDetails.AccountCodesType/g"               java/com/triplake/adapter/kmapi/jaxrs/api/model/BrandedSegmentDetails.java
sed -i "s/BrandedSegmentDetails.FareBasisCodesType/UnbrandedSegmentDetails.FareBasisCodesType/g"                     java/com/triplake/adapter/kmapi/jaxrs/api/model/BrandedSegmentDetailsImpl.java
sed -i "s/BrandedSegmentDetails.AccountCodesType/UnbrandedSegmentDetails.AccountCodesType/g"                          java/com/triplake/adapter/kmapi/jaxrs/api/model/BrandedSegmentDetailsImpl.java


sed -i "s/ SegmentsType getSegments/AncillarySearchVerboseResponse.SegmentsType getSegments/g"   java/com/triplake/adapter/kmapi/jaxrs/api/model/AncillariesSearchAdvancedResponse.java
sed -i "s/ setSegments.SegmentsType/ setSegments( AncillarySearchVerboseResponse.SegmentsType/g" java/com/triplake/adapter/kmapi/jaxrs/api/model/AncillariesSearchAdvancedResponse.java
sed -i "s/ SegmentsType getSegments/AncillarySearchVerboseResponse.SegmentsType getSegments/g"   java/com/triplake/adapter/kmapi/jaxrs/api/model/AncillariesSearchForPNRResponse.java
sed -i "s/ setSegments.SegmentsType/ setSegments( AncillarySearchVerboseResponse.SegmentsType/g" java/com/triplake/adapter/kmapi/jaxrs/api/model/AncillariesSearchForPNRResponse.java

sed -i 's/AncillariesSearchAdvancedResponse.SegmentsType/AncillarySearchVerboseResponse.SegmentsType/g' java/com/triplake/adapter/kmapi/jaxrs/api/model/AncillariesSearchAdvancedResponseImpl.java
sed -i 's/AncillariesSearchForPNRResponse.SegmentsType/AncillarySearchVerboseResponse.SegmentsType/g' java/com/triplake/adapter/kmapi/jaxrs/api/model/AncillariesSearchForPNRResponseImpl.java

sed -i 's/ TaxType getTax/ FormOfPaymentType.TaxType getTax/g' java/com/triplake/adapter/kmapi/jaxrs/api/model/FormOfPaymentType.java
sed -i 's/ TaxType getTax/ FormOfPaymentType.TaxType getTax/g' java/com/triplake/adapter/kmapi/jaxrs/api/model/CreditCardFOP.java
sed -i 's/ TaxType getTax/ FormOfPaymentType.TaxType getTax/g' java/com/triplake/adapter/kmapi/jaxrs/api/model/InvoiceFOP.java

sed -i 's/setTax.TaxType/ setTax(FormOfPaymentType.TaxType/g' java/com/triplake/adapter/kmapi/jaxrs/api/model/CreditCardFOP.java
sed -i 's/setTax.TaxType/ setTax(FormOfPaymentType.TaxType/g' java/com/triplake/adapter/kmapi/jaxrs/api/model/InvoiceFOP.java

sed -i 's/CreditCardFOP.TaxType/ FormOfPaymentType.TaxType/g' java/com/triplake/adapter/kmapi/jaxrs/api/model/CreditCardFOPImpl.java
sed -i 's/InvoiceFOP.TaxType/ FormOfPaymentType.TaxType/g' java/com/triplake/adapter/kmapi/jaxrs/api/model/InvoiceFOPImpl.java

sed -i 's/com.triplake.adapter.kmapi.jaxrs.api.model.PassengerTicket/PassengerTicket/g'  java/com/triplake/adapter/kmapi/jaxrs/api/model/AbbreviatedTicketDetails.java
sed -i 's/ PassengerTicketImpl.class/ AbbreviatedTicketDetailsImpl.PassengerTicketImpl.class/g'  java/com/triplake/adapter/kmapi/jaxrs/api/model/AbbreviatedTicketDetails.java
# any object
grep --files-with-matches "Root" java/com/triplake/adapter/kmapi/jaxrs/api/model/*.java | xargs sed -i 's/<Root>/<com.triplake.adapter.kmapi.jaxrs.api.model.fix.Any>/'

# fix up resource.. remove delegate
sed -i 's/PostFlightsSearchResponse postFlightsSearch/SearchFlightResponse postFlightsSearch/g' java/com/triplake/adapter/kmapi/jaxrs/api/resource/Flights.java
sed -i 's/PostReservationsQuoteResponse postReservationsQuote/QuoteReservationResponse postReservationsQuote/g' java/com/triplake/adapter/kmapi/jaxrs/api/resource/Reservations.java
sed -i 's/PostReservationsResponse postReservations/CreateReservationResponse postReservations/g' java/com/triplake/adapter/kmapi/jaxrs/api/resource/Reservations.java
sed -i 's/GetReservationsByPnrLocatorResponse getReservationsByPnrLocator/GetReservationResponse getReservationsByPnrLocator/g' java/com/triplake/adapter/kmapi/jaxrs/api/resource/Reservations.java
sed -i 's/PostTicketsIssueResponse postTicketsIssue/TicketsIssueResponse postTicketsIssue/g' java/com/triplake/adapter/kmapi/jaxrs/api/resource/Tickets.java

